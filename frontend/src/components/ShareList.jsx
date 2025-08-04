import React from 'react'
import { Link } from 'react-router-dom';

const ShareList = ({ shares }) => {
  return (
    <div className="blog-list">
      {shares.map((share, index) => (
        <div className="blog-preview" key={share.id}>
          <Link to={`/shares/${index + 1}`}>
            <h2>{share.shareName} - {index + 1}</h2>
            <p>Market Price : {share.market_price}</p>
            <p>{share.issueDate}</p>
          </Link>
        </div>
      ))}
    </div>

  )
}

export default ShareList
