import styles from "./styles.module.scss";
import { FaGear } from "react-icons/fa6";




const AdminHeader = () => {
    return (
        <header className={styles["admin-header"]}>
            <div className="container">
                <FaGear />



            </div>
        </header>
    );
}

export default AdminHeader;