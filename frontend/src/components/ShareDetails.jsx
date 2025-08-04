import React, { useEffect, useState } from 'react';
import { useParams } from "react-router-dom";

const ShareDetails = () => {
  const { id } = useParams();
  const [share, setShare] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    // Replace with your actual API endpoint
    fetch(`http://localhost:8088/shares/${id}`)
      .then(res => res.json())
      .then(data => {
        setShare(data);
        setLoading(false);
      })
      .catch(err => {
        console.error("Failed to fetch share:", err);
        setLoading(false);
      });
  }, [id]);

  if (loading) return <p>Loading share details...</p>;
  if (!share) return <p>No share found with ID {id}</p>;

  return (
    <div className="share-details">
      <h2>Share Details</h2>
      <p><strong>ID:</strong> {share.shareId}</p>
      <p><strong>Name:</strong> {share.shareName}</p>
      <p><strong>Market Price:</strong> ₹{share.market_price}</p>
      <p><strong>Issue Date:</strong> {share.issueDate}</p>
    </div>
  );
};

export default ShareDetails;
