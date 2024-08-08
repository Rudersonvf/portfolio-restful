import { requestBackend } from "../utils/requests"

export const findAllExperiences = () => {
    const config = {
        method: "GET",
        url: "/experiences"
    };
    return requestBackend(config);
}