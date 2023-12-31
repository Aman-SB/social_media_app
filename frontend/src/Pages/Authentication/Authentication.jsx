import { Card, Grid } from "@mui/material";
import React from "react";
import Login from "./Login";
import Register from "./Register";


const Authentication = () => {
    return (
        <div>
            <Grid container>
                <Grid className="flex justify-center h-screen overflow-hidden" item xs={7} >
                    <img className="" src="../../../public/icon/customicon.webp" alt="" />
                </Grid>
                <Grid item xs={5} >
                    <div className="px-20 flex flex-col justify-center h-full ">
                        <Card className="card p-8">
                            <div className="flex flex-col items-center mb-5 space-y-1">
                                <h1 className="logo text-center">
                                    Connect-Hub
                                </h1>
                                <p className="text-center text-sm w-[70%] ">
                                    Your World Your Way
                                </p>
                            </div>
                            {/* <Login/>
                            <Register/> */}
                        </Card>
                    </div>
                </Grid>
            </Grid>
        </div>
    );
};

export default Authentication;
