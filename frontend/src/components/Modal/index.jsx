import styles from "./styles.module.scss";

// Componente principal Modal que por si só não renderiza nada
const Modal = () => {
  return null; // O Modal principal não renderiza nada diretamente
};

// Definição do modal SaveEdit como uma subpropriedade de Modal
Modal.SaveEdit = ({ isOpen, onClose, title, children }) => {
  if (!isOpen) return null; // Não renderiza se não estiver aberto

  return (
    <>
      <div className={styles["modal-overlay"]} onClick={onClose}></div>
      <div className={styles["modal-container"]}>
        <h4>{title}</h4>
        <div>{children}</div>
      </div>
    </>
  );
};

// Define o displayName para evitar o aviso do ESLint
Modal.SaveEdit.displayName = "Modal.SaveEdit";

export default Modal;
