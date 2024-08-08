import { useEffect, useState } from "react";
import * as experienceService from "../../../services/experience-service";
import styles from "./styles.module.scss";
import ExperienceTableItem from "../../../components/ExperienceTableItem";

const Experiences = () => {
    const [experiences, setExperiences] = useState([]);

    useEffect(() => {
        fetchAll();
    }, [])

    const fetchAll = () => {
        experienceService.findAllExperiences()
            .then((response) => {
                setExperiences(response.data)
            });
    }

    return (
        <main>
            <div className={`${styles["page-experiences"]} container`}>
                <h3>Experiências</h3>
                <div className={styles["content"]}>
                    <div className={styles["table-container"]}>
                        <table>
                            <thead>
                                <tr>
                                    <th>Empresa</th>
                                    <th>Cargo</th>
                                    <th>Inicio</th>
                                    <th>Fim</th>
                                    <th>Ações</th>
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
            </div>
        </main>
    );
}

export default Experiences;
