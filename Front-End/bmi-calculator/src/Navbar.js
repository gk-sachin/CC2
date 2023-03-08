import { Link } from "react-router-dom";

function Navbar() {
  return (
    <div className="navbar">
    <Link to="/">home</Link>
    <Link to="/check">Check</Link>
    </div>
  );
}

export default Navbar;