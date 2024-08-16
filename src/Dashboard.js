import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './Dashboard.css';
import Sidebar from './Sidebar';

const menuData = [
  { id: 1, name: 'Order 1', price: 100, popularity: 4, totalQuantity: 1 },
  { id: 2, name: 'Order 2', price: 200, popularity: 5, totalQuantity: 1 },
  { id: 3, name: 'Order 3', price: 150, popularity: 3, totalQuantity: 1 },
  { id: 4, name: 'Order 4', price: 300, popularity: 2, totalQuantity: 1 },
  // Add more menu items as needed
];

const getImageUrl = (itemid) => {
  if (itemid === 1) return 'https://cdn.pixabay.com/photo/2021/11/01/15/52/spring-roll-6760871_640.jpg';
  if (itemid === 2) return 'https://cdn.pixabay.com/photo/2016/11/06/23/31/breakfast-1804457_640.jpg';
  if (itemid === 3) return 'https://cdn.pixabay.com/photo/2014/05/23/23/17/dessert-352475_1280.jpg';
  return 'https://cdn.pixabay.com/photo/2014/10/19/20/59/hamburger-494706_640.jpg';
};

const Menu = ({ menuItems, addToOrder }) => (
  <table>
    <tbody>
      {menuItems.map((item) => (
        <tr key={item.id} className="menu-item">
          <td>
            <img src={getImageUrl(item.id)} alt={item.name} />
          </td>
          <td>
            <h3>{item.name}</h3>
            <p>Category: {item.category}</p>
            <p>Price: ${item.price}</p>
          </td>
          <td>
            <button onClick={() => addToOrder(item.id)}>Add More</button>
          </td>
        </tr>
      ))}
    </tbody>
  </table>
);

const OrderSummary = ({ orderItems, removeFromOrder, totalAmount }) => (
  <div className="order-container">
    <h2>Your Order Summary</h2>
    <p><i>Enjoy the delicious authentic food with us. Your total bill amount is:</i></p>
    <table>
      <tbody>
        {orderItems.map((item) => (
          <tr key={item.id} data-item-id={item.id}>
            <td><strong>{item.name}</strong></td>
            <td><span className="quantity">{item.totalQuantity}</span> x ${item.price}</td>
            <td><button onClick={() => removeFromOrder(item.id)}>Remove</button></td>
          </tr>
        ))}
      </tbody>
    </table>
    <div>Total Amount: ${totalAmount.toFixed(2)}</div>
    <button onClick={() => alert('Order placed successfully!')}>Place Order</button>
  </div>
);

const Dashboard = () => {
  const [menuItems, setMenuItems] = useState(menuData);
  const [orderItems, setOrderItems] = useState([]);
  const [totalAmount, setTotalAmount] = useState(0);
  const [searchTerm, setSearchTerm] = useState('');
  const [sortOption, setSortOption] = useState('price');

  const navigate = useNavigate();

  const addToOrder = (itemId) => {
    const item = menuItems.find((menuItem) => menuItem.id === itemId);
    const orderItem = orderItems.find((orderItem) => orderItem.id === itemId);

    if (orderItem) {
      const updatedOrderItems = orderItems.map((orderItem) =>
        orderItem.id === itemId ? { ...orderItem, totalQuantity: orderItem.totalQuantity + 1 } : orderItem
      );
      setOrderItems(updatedOrderItems);
    } else {
      setOrderItems([...orderItems, { ...item, totalQuantity: 1 }]);
    }

    setTotalAmount(totalAmount + item.price);
    navigate('/app');
  };

  const removeFromOrder = (itemId) => {
    const item = orderItems.find((orderItem) => orderItem.id === itemId);

    if (item.totalQuantity > 1) {
      const updatedOrderItems = orderItems.map((orderItem) =>
        orderItem.id === itemId ? { ...orderItem, totalQuantity: orderItem.totalQuantity - 1 } : orderItem
      );
      setOrderItems(updatedOrderItems);
    } else {
      setOrderItems(orderItems.filter((orderItem) => orderItem.id !== itemId));
    }

    setTotalAmount(totalAmount - item.price);
  };

  const filteredMenuItems = menuItems.filter(
    (item) =>
      item.name.toLowerCase().includes(searchTerm.toLowerCase()) ||
      item.category.toLowerCase().includes(searchTerm.toLowerCase())
  );

  const sortedMenuItems = [...filteredMenuItems].sort((a, b) => a[sortOption] - b[sortOption]);

  return (
    <div className="content">
      <Sidebar />
      <h1>Ordering Dashboard</h1>
      <div>
        <label htmlFor="search">Search your Order:</label>
        <input
          type="text"
          id="search"
          placeholder="Search for Orders..."
          value={searchTerm}
          onChange={(e) => setSearchTerm(e.target.value)}
        />
      </div>
      <div>
        <label htmlFor="sort">Sort by:</label>
        <select id="sort" value={sortOption} onChange={(e) => setSortOption(e.target.value)}>
          <option value="price">Price</option>
          <option value="popularity">Time</option>
        </select>
      </div>
      <div className="menu-container">
        <Menu menuItems={sortedMenuItems} addToOrder={addToOrder} />
      </div>
      <OrderSummary orderItems={orderItems} removeFromOrder={removeFromOrder} totalAmount={totalAmount} />
    </div>
  );
};

export default Dashboard;
