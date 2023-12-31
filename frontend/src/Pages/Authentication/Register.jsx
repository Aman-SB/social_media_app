import { Button, FormControlLabel, Radio, RadioGroup, TextField } from "@mui/material";
import { ErrorMessage, Field, Form, Formik } from "formik";
import React, { useState } from "react";
import * as Yup from "yup";

const initialValue = {
    firstName: "",
    lastName: "",
    email: "",
    password: "",
    gender: ""
};
const validationSchema = {
    email: Yup.string().email("Invalid email").required("Email is required"),
    password: Yup.string()
        .min(6, "Password must be at least 6 characters")
        .required("Password is required"),
};
const Register = () => {
    const [gender,setGender] = useState(null)
    const handleSubmit = (value) => {
        value.gender = gender
        console.log("handle submit" , value);
    };

    return (
        <>
            <Formik
                onSubmit={handleSubmit}
                // validationSchema={validationSchema}
                initialValues={initialValue}
            >
                <Form className="space-y-5">
                    <div className="space-y-5">
                        <div>
                            <Field
                                as={TextField}
                                name="firstName"
                                placeholder="firstName"
                                type="text"
                                variant="outlined"
                                fullWidth
                            />
                            <ErrorMessage
                                name="firstName"
                                component="div"
                                className="text-red-500"
                            />
                        </div>
                        <div>
                            <Field
                                as={TextField}
                                name="lastName"
                                placeholder="LastName"
                                type="text"
                                variant="outlined"
                                fullWidth
                            />
                            <ErrorMessage
                                name="lastname"
                                component="div"
                                className="text-red-500"
                            />
                        </div>
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
                                component="div"
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
                                component="div"
                                className="text-red-500"
                            />
                        </div>
                        <RadioGroup onChange={(e) => setGender(e.target.value)}
                            row
                            aria-labelledby="gender"
                            name="gender"
                        >
                            <FormControlLabel
                                value="FEMALE"
                                control={<Radio />}
                                label="Female"
                            />
                            <FormControlLabel
                                value="MALE"
                                control={<Radio />}
                                label="Male"
                            />
                            <FormControlLabel
                                value="OTHER"
                                control={<Radio />}
                                label="Other"
                            />
                            <ErrorMessage
                                name="gender"
                                component="div"
                                className="text-red-500"
                            />
                        </RadioGroup>
                    </div>
                    <Button
                        sx={{ padding: ".8rem 0rem" }}
                        fullWidth
                        type="submit"
                        variant="contained"
                        color="primary"
                    >
                        Register
                    </Button>
                </Form>
            </Formik>
        </>
    );
};

export default Register;
