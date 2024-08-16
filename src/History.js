import React from 'react';
import './History.css';

const orders = [
  { id: 1, product: 'Order 1', address: '123 Elm Street, Springfield', date: '2024-07-15' },
  { id: 2, product: 'Order 2', address: '456 Oak Avenue, Springfield', date: '2024-07-16' },
  { id: 3, product: 'Order 3', address: '789 Pine Road, Springfield', date: '2024-07-17' },
  { id: 4, product: 'Order 4', address: '101 Maple Street, Springfield', date: '2024-07-18' },
  // Add more orders as needed
];

const History = () => {
  return (
    <div className="history-container">
      <h1>Order History</h1>
      <table className="history-table">
        <thead>
          <tr>
            <th>Date</th>
            <th>Product</th>
            <th>Address</th>
          </tr>
        </thead>
        <tbody>
          {orders.map(order => (
            <tr key={order.id}>
              <td>{order.date}</td>
              <td>{order.product}</td>
              <td>{order.address}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default History;
