import { useEffect, useState } from "react";
import * as experienceService from "../../../services/experience-service";
import styles from "./styles.module.scss";
import ExperienceTableItem from "../../../components/ExperienceTableItem";
import Modal from "../../../components/Modal";
import Button from "../../../components/Button";

const Experiences = () => {
  const [experiences, setExperiences] = useState([]);
  const [isModalOpen, setIsModalOpen] = useState(true);
  const [modalTitle, setModalTitle] = useState("zirimba");

  useEffect(() => {
    fetchAll();
  }, []);

  const fetchAll = () => {
    experienceService.findAllExperiences().then((response) => {
      setExperiences(response.data);
    });
  };

  return (
    <main>
      <div className={`${styles["page-experiences"]} container`}>
        <div className={styles["page-header"]}>
          <h3 className="">Experiências</h3>
          <Button />
        </div>
        <div className={styles["content"]}>
          <div className={styles["table-container"]}>
            <table>
              <thead>
                <tr>
                  <th>Empresa</th>
                  <th>Cargo</th>
                  <th>Inicio</th>
                  <th>Fim</th>
                  <th className="text-end">Ações</th>
                </tr>
              </thead>
              <tbody>
                {experiences.map((experience, index) => (
                  <ExperienceTableItem
                    key={index}
                    company={experience.company}
                    startDate={experience.startDate}
                    endDate={experience.endDate}
                    position={experience.position}
                  />
                ))}
              </tbody>
            </table>
          </div>
        </div>
        <Modal.SaveEdit isOpen={false} title={modalTitle} />
      </div>
    </main>
  );
};

export default Experiences;
