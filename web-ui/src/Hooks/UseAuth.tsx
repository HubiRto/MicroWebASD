import {useContext} from "react";
import {AuthContext} from "../Provider/AuthContext.tsx";

export const UseAuth = () => {
    return useContext(AuthContext);
}