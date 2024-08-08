import PropTypes from 'prop-types';
import styles from "./styles.module.scss";
import { FaTrash, FaPenToSquare } from "react-icons/fa6";

const ExperienceTableItem = ({ company, startDate, endDate, position }) => {
    return (
        <tr className={styles["experience-table-item"]}>
            <td>{company}</td>
            <td>{startDate}</td>
            <td>{endDate}</td>
            <td>{position}</td>
            <td className={styles["action-container"]}>
                <div>
                    <FaPenToSquare />
                </div>
                <div>
                    <FaTrash />
                </div>
            </td>
        </tr>
    );
};

ExperienceTableItem.propTypes = {
    company: PropTypes.string.isRequired,
    startDate: PropTypes.string.isRequired,
    endDate: PropTypes.string.isRequired,
    position: PropTypes.string.isRequired,
};

export default ExperienceTableItem;
