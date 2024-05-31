import React, {FormEvent, useState} from "react";
import axios, {AxiosError} from "axios";
import {UseAuth} from "../Hooks/UseAuth.tsx";
import {useNavigate} from 'react-router-dom';

enum ErrorType {
    MISSING_CREDENTIALS = 'MISSING_CREDENTIALS',
    UNAUTHORIZED = 'UNAUTHORIZED',
    LOGIN_FAILED = 'LOGIN_FAILED',
    NO_SERVER_RESPONSE = 'NO_SERVER_RESPONSE'
}

const ErrorMessages = {
    [ErrorType.MISSING_CREDENTIALS]: {
        title: 'Brak nazwy użytkownika lub hasła',
        message: 'Proszę podać nazwę użytkownika i hasło.'
    },
    [ErrorType.UNAUTHORIZED]: {
        title: 'Brak autoryzacji',
        message: 'Nie masz uprawnień dostępu. Sprawdź swoje dane logowania.'
    },
    [ErrorType.LOGIN_FAILED]: {
        title: 'Błąd logowania',
        message: 'Nie udało się zalogować. Sprawdź swoje dane logowania.'
    },
    [ErrorType.NO_SERVER_RESPONSE]: {
        title: 'Brak odpowiedzi serwera',
        message: 'Nie można połączyć się z serwerem. Sprawdź swoje połączenie internetowe.'
    }
};

const Login = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [showToast, setShowToast] = useState(false);

    const [errorType, setErrorType] = useState<ErrorType | null>(null);
    const [success, setSuccess] = useState(false);

    const {setAuthenticated} = UseAuth();
    const navigate = useNavigate();

    const handleChange = (e: { target: { value: React.SetStateAction<string> } }) => {
        setEmail(e.target.value);
        setShowToast(false);
    };

    const handleSubmit = async (e: FormEvent) => {
        e.preventDefault();

        try {
            const response = await axios.post("http://localhost:8080/api/v1/auth/login",
                JSON.stringify({email, password}),
                {
                    headers: {'Content-Type': 'application/json'}
                }
            );
            console.log(JSON.stringify(response?.data));
            localStorage.setItem("token", response?.data.token);
            localStorage.setItem("refreshToken", response?.data.refreshToken);

            setAuthenticated(true);
            setSuccess(true);
            setShowToast(true);
            navigate("/", {replace: true});
        } catch (err) {
            if ((err as AxiosError)?.response) {
                const axiosErr = err as AxiosError;
                if (axiosErr.response?.status === 400) {
                    setErrorType(ErrorType.MISSING_CREDENTIALS);
                } else if (axiosErr.response?.status === 401) {
                    setErrorType(ErrorType.UNAUTHORIZED);
                } else {
                    setErrorType(ErrorType.LOGIN_FAILED);
                }
            } else {
                setErrorType(ErrorType.NO_SERVER_RESPONSE);
            }
            setShowToast(true);
        }
    };

    return (
        <>
            <div className="min-h-screen items-center justify-center bg-gray-300 py-12 px-4 sm:px-6 lg:px-8">
                <h1 className="text-4xl font-extrabold dark:text-dark-800">Pomoku</h1>
                <div id="toast-top-right"
                     className={`fixed flex z-20 border items-center w-full max-w-xs p-4 space-x-4 text-gray-500 bg-white divide-x rtl:divide-x-reverse divide-gray-200 rounded-lg shadow top-5 right-5 dark:text-gray-400 dark:divide-gray-700 space-x dark:bg-gray-800 ${showToast ? '' : 'hidden'}`}
                     role="alert">
                    <div className="flex">
                        {success ? (
                            <div
                                className="inline-flex items-center justify-center flex-shrink-0 w-8 h-8 text-green-500 bg-green-100 rounded-lg dark:text-green-300 dark:bg-green-900">
                                <svg className="w-4 h-4" xmlns="http://www.w3.org/2000/svg" fill="none"
                                     viewBox="0 0 24 24" stroke="currentColor">
                                    <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2"
                                          d="M5 13l4 4L19 7"/>
                                </svg>
                                <span className="sr-only">Success icon</span>
                            </div>
                        ) : (
                            <div
                                className="inline-flex items-center justify-center flex-shrink-0 w-8 h-8 text-red-500 bg-red-100 rounded-lg dark:text-red-300 dark:bg-red-900">
                                <svg className="w-4 h-4" xmlns="http://www.w3.org/2000/svg" fill="none"
                                     viewBox="0 0 24 24" stroke="currentColor">
                                    <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2"
                                          d="M6 18L18 6M6 6l12 12"/>
                                </svg>
                                <span className="sr-only">Error icon</span>
                            </div>
                        )}
                        <div className="ms-3 text-sm font-normal">
                            <span
                                className={`mb-1 text-sm font-semibold ${success ? 'text-gray-900' : 'text-red-500'} dark:text-white`}>
                                {success ? 'Poprawnie zalogowano' : errorType ? `Błąd: ${ErrorMessages[errorType].title}` : ''}
                            </span>
                            <div className="mb-2 text-sm font-normal">
                                {errorType ? `${ErrorMessages[errorType].message}` : ''}
                            </div>
                        </div>
                        <button type="button"
                                className="ms-auto -mx-1.5 -my-1.5 bg-white items-center justify-center flex-shrink-0 text-gray-400 hover:text-gray-900 rounded-lg focus:ring-2 focus:ring-gray-300 p-1.5 hover:bg-gray-100 inline-flex h-8 w-8 dark:text-gray-500 dark:hover:text-white dark:bg-gray-800 dark:hover:bg-gray-700"
                                data-dismiss-target="#toast-interactive" aria-label="Close"
                                onClick={() => setShowToast(false)}>
                            <span className="sr-only">Close</span>
                            <svg className="w-3 h-3" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none"
                                 viewBox="0 0 14 14">
                                <path stroke="currentColor" strokeLinecap="round" strokeLinejoin="round" strokeWidth="2"
                                      d="m1 1 6 6m0 0 6 6M7 7l6-6M7 7l-6 6"/>
                            </svg>
                        </button>
                    </div>
                </div>


                <div className="max-w-lg mx-auto my-10 p-6 bg-gray-800 rounded-md shadow-md relative">
                    <h2 className="text-2xl text-white font-semibold mb-6">Logowanie</h2>
                    <form onSubmit={handleSubmit}>
                        <div className="mb-4">
                            <label htmlFor="email" className="block text-sm font-medium text-gray-400">
                                Adres Email
                            </label>
                            <input
                                type="email"
                                id="email"
                                className="mt-1 p-2 block w-full border rounded-md bg-gray-700 text-white"
                                value={email}
                                onChange={handleChange}
                                placeholder="Email"
                                required
                            />
                        </div>
                        <div className="mb-4">
                            <label htmlFor="password" className="block text-sm font-medium text-gray-400">
                                Hasło
                            </label>
                            <input
                                type="password"
                                id="password"
                                className="mt-1 p-2 block w-full border rounded-md bg-gray-700 text-white"
                                value={password}
                                onChange={(e) => setPassword(e.target.value)}
                                placeholder="Hasło"
                                required
                            />
                        </div>
                        <div className="mt-6">
                            <button
                                type="submit"
                                className="w-full py-2 px-4 border border-transparent rounded-md shadow-sm text-sm font-medium text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500"
                            >
                                Zaloguj się
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </>
    );
}

export default Login