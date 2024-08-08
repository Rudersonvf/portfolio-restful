import { useEffect, useState } from "react";
import * as experienceService from "../../../services/experience-service";
import styles from "./styles.module.scss";

const Experiences = () => {
    const [experiences, setExperiences] = useState({});

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
                    <h1>CONTEUDO</h1>
                </div>
            </div>
        </main>
    );
}

export default Experiences;
