import {Navigate, Outlet, useLocation} from "react-router-dom";
import {UseAuth} from "../Hooks/UseAuth.tsx";

const RequireAuth = () => {
    const {authenticated} = UseAuth();
    const location = useLocation();

    return (
        authenticated ? <Outlet/> : <Navigate to="/login" state={{from: location}} replace/>
    );
}

export default RequireAuth;