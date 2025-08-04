// import { useEffect, useState } from "react";
import useFetch from "../components/useFetch";
import ShareList from "./ShareList";


const Home = () => {
  const { error, isPending, data: shares } = useFetch('http://localhost:8088/shares')
  console.log(shares);
  return (
    <div className="home">
      { error && <div>{ error }</div> }s
      { isPending && <div>Loading...</div> }
      { shares && <ShareList shares={shares} /> }
    </div>
  );
}
 
export default Home;
