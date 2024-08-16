import React, { useState, useRef, useEffect } from 'react';
import './App.css';

const useCamera = (active, videoRef, canvasRef, setImageSrc) => {
  useEffect(() => {
    let stream;
    if (active) {
      navigator.mediaDevices.getUserMedia({ video: true })
        .then(s => {
          stream = s;
          if (videoRef.current) {
            videoRef.current.srcObject = stream;
          }
        })
        .catch(err => console.error("Error accessing camera: ", err));
    }
    return () => {
      if (stream) {
        stream.getTracks().forEach(track => track.stop());
      }
    };
  }, [active, videoRef, canvasRef, setImageSrc]);
};

const TabsComponent = () => {
  const [state, setState] = useState({
    activeTab: 1,
    activeSubTab: 'notes',
    cameraActive: false,
    imageSrc: { 1: null, 2: null, 3: null, 4: null },
  });

  const videoRefs = useRef({ 1: null, 2: null, 3: null, 4: null });
  const canvasRefs = useRef({ 1: null, 2: null, 3: null, 4: null });

  const { activeTab, activeSubTab, cameraActive, imageSrc } = state;

  useCamera(cameraActive && activeSubTab === 'camera', videoRefs.current[activeTab], canvasRefs.current[activeTab], setImageSrc);

  const captureImage = () => {
    const context = canvasRefs.current[activeTab].getContext('2d');
    context.drawImage(videoRefs.current[activeTab], 0, 0, canvasRefs.current[activeTab].width, canvasRefs.current[activeTab].height);
    setState(prevState => ({
      ...prevState,
      imageSrc: { ...prevState.imageSrc, [activeTab]: canvasRefs.current[activeTab].toDataURL('image/png') },
    }));
  };

  const openCamera = () => setState({ ...state, cameraActive: true });
  const closeCamera = () => {
    setState({ ...state, cameraActive: false });
    if (videoRefs.current[activeTab] && videoRefs.current[activeTab].srcObject) {
      videoRefs.current[activeTab].srcObject.getTracks().forEach(track => track.stop());
    }
  };

  const changeTab = (num) => setState({ ...state, activeTab: num });
  const changeSubTab = (subTab) => setState({ ...state, activeSubTab: subTab });

  return (
    <article className="article">
      <div className="grid__item--1of1 text-center">
        <h2>Add your Orders</h2>
        <div className="tabs">
          {[1, 2, 3, 4].map(num => (
            <React.Fragment key={num}>
              <input 
                type="radio" 
                name="tabs" 
                id={`tab${num}`} 
                checked={activeTab === num} 
                onChange={() => changeTab(num)} 
              />
              <label htmlFor={`tab${num}`}>
                <i className={`icon ${num === 1 ? 'email-cal' : num === 2 ? 'snapshot' : num === 3 ? 'inbox-apps' : 'log-calls'}`}></i>
                <span>{`Order ${num}`}</span>
              </label>
            </React.Fragment>
          ))}

          {[1, 2, 3, 4].map(num => (
            <div key={num} className={`tab__content ${activeTab === num ? 'active' : ''}`} id={`tab__content--${num}`}>
              <div className="sub-tabs">
                <button onClick={() => changeSubTab('notes')}>Notes</button>
                <button onClick={() => changeSubTab('camera')}>Camera</button>
              </div>
              {activeSubTab === 'camera' ? (
                <div>
                  {cameraActive ? (
                    <>
                      {imageSrc[num] ? (
                        <img src={imageSrc[num]} alt="Captured" />
                      ) : (
                        <div>
                          <video ref={el => videoRefs.current[num] = el} autoPlay width="200" height="200"></video>
                          <button onClick={captureImage}>Capture Image</button>
                          <canvas ref={el => canvasRefs.current[num] = el} style={{ display: 'none' }} width="200" height="200"></canvas>
                        </div>
                      )}
                      <button onClick={closeCamera}>Close Camera</button>
                    </>
                  ) : (
                    <button onClick={openCamera}>Open Camera</button>
                  )}
                </div>
              ) : (
                <textarea placeholder="Write your notes here..." rows="10" cols="50"></textarea>
              )}
            </div>
          ))}
        </div>
      </div>
    </article>
  );
};

export default TabsComponent;
