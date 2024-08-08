import { Outlet } from "react-router-dom";
import AdminAside from "../../components/AdminAside";
import AdminHeader from "../../components/AdminHeader";

const Admin = () => {
    return(
        <div className="d-flex">
        <AdminAside/>
        <div className="container">
            <AdminHeader/>
            <Outlet/>
        </div>
        </div>
    );
}

export default Admin;