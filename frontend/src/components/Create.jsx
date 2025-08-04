import React, { useState } from 'react';

const Create = () => {
  const [formData, setFormData] = useState({
    shareId: '',
    shareName: '',
    issueDate: '',
    market_price: ''
  });


  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({
      ...prev,
      [name]: name === 'market_price' || name === 'shareId' ? Number(value) : value
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await fetch('http://localhost:8088/shares', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(formData)
      });

      if (response.ok) {
        alert('✅ Share created successfully!');
      } else {
        const error = await response.text();
        alert('❌ Failed: ' + error);
      }
    } catch (err) {
      console.error(err);
      alert('❌ Error sending request');
    }
  };

  return (
    <div className='create-container'>
      <h2>Add a Share</h2>
      <form onSubmit={handleSubmit} className='create-form'>
        <label>
          Share ID:
          <input
            type="number"
            name="shareId"
            value={formData.shareId}
            onChange={handleChange}
            required
          />
        </label>

        <label>
          Share Name:
          <input
            type="text"
            name="shareName"
            value={formData.shareName}
            onChange={handleChange}
            required
          />
        </label>

        <label>
          Issue Date:
          <input
            type="date"
            name="issueDate"
            value={formData.issueDate}
            onChange={handleChange}
            required
          />
        </label>

        <label>
          Market Price:
          <input
            type="number"
            name="market_price"
            value={formData.market_price}
            onChange={handleChange}
            required
          />
        </label>

        <button type="submit">Create Share</button>
      </form>
    </div>
  );
};

export default Create;