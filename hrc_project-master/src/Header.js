import "./Header.css";
import logo from "./logo.png"
const Header = () => {
  return (
    <div className="Header_home">
      <div className="company_name">
        <img src= {logo} />
      </div>
      <img
        className="img_hrc"
        height={"40"}
        width={"200"}
        src="https://cdn-resources.highradius.com/resources/wp-content/uploads/2020/04/highradius-logo-3.png"
      ></img>
    </div>
  );
};

export default Header;
