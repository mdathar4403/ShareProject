import { Link } from "react-router-dom";

const Navbar = () => {
  return (
    <nav className="navbar">
      <h1>The Share App</h1>
      <div className="links">
        <Link to="/">Home</Link>
        <Link to="/create">New Share</Link>
      </div>
    </nav>
  );
}
 
export default Navbar;