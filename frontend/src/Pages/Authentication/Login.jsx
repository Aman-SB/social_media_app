import { Button, TextField } from "@mui/material";
import { ErrorMessage, Field, Form, Formik } from "formik";
import React, { useState } from "react";
import * as Yup from "yup";

const initialValue = {
    firstName: "",
    lastName: "",
    email: "",
    password: "",
    gender: "",
};
const validationSchema = {
    email: Yup.string().email("Invalid email").required("Email is required"),
    password: Yup.string()
        .min(6, "Password must be at least 6 characters")
        .required("Password is required"),
};
const Login = () => {
    // const [formValue, setFormValue] = useState()
    const [gender, setGender] = useState(null);
    const handleSubmit = (values) => {
        console.log("handle submit");
    };

    return (
        <>
            <Formik
                onSubmit={handleSubmit}
                validationSchema={validationSchema}
                initialValues={initialValue}
            >
                <Form className="space-y-5">
                    <div className="space-y-5">
                        <div>
                            <Field
                                as={TextField}
                                name="email"
                                placeholder="Email"
                                type="email"
                                variant="outlined"
                                fullWidth
                            />
                            <ErrorMessage
                                name="email"
                                component={"div"}
                                className="text-red-500"
                            />
                        </div>
                        <div>
                            <Field
                                as={TextField}
                                name="password"
                                placeholder="password"
                                type="password"
                                variant="outlined"
                                fullWidth
                            />
                            <ErrorMessage
                                name="password"
                                component={"div"}
                                className="text-red-500"
                            />
                        </div>
                    </div>
                    <Button
                        sx={{ padding: ".8rem 0rem" }}
                        fullWidth
                        type="submit"
                        variant="contained"
                        color="primary"
                    >
                        Login
                    </Button>
                </Form>
            </Formik>
        </>
    );
};

export default Login;
