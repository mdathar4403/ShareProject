import React from 'react'
import { Link } from 'react-router-dom';

const ShareList = ({shares}) => {
  return (
    <div className="blog-list">
      {shares.map(share => (
        <div className="blog-preview" key={share.id} >
          <Link to={`/shares/${share.id}`}>
            <h2>{ share.shareName }</h2>
            <p>Market Price : { share.market_price }</p>
          </Link>
        </div>
      ))}
    </div>
  )
}

export default ShareList
