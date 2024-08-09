import PropTypes from "prop-types";
import styles from "./styles.module.scss";

const Button = ({ title, type = "primary" }) => {
  const buttonClass = type === "primary" ? "btn-primary" : "btn-secondary";

  return (
    <div className={styles["component-button"]}>
      <button className={`${styles["btn"]} ${styles[buttonClass]}`}>
        {title}
      </button>
    </div>
  );
};

Button.propTypes = {
  title: PropTypes.string.isRequired,
  type: PropTypes.oneOf(["primary", "secondary"]),
};

export default Button;
