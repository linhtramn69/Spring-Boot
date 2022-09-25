import React, { useState } from "react"
import axios from "axios"
import { useNavigate } from "react-router-dom"
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome"
import { faPhone, faUser, faLock, faVenusMars, faAddressCard } from "@fortawesome/free-solid-svg-icons"
import { Container, Row, Col, Form, Button } from "react-bootstrap"
import { faCalendarDays } from "@fortawesome/free-regular-svg-icons"
import { toast } from "react-toastify"

function Register() {
    const [formValues, setFormValues] = useState({});

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormValues({ ...formValues, [name]: value });
    }
    let navigate = useNavigate();

    const handleRegister = (e) => {
        const data = {
            "ho": formValues.ho,
            "ten": formValues.ten,
            "ngaysinh": formValues.ngaysinh,
            "phai": formValues.phai,
            "sdt": formValues.sdt,
            "account": {
                "username": formValues.username,
                "password": formValues.password
            }
        }
   
        axios
            .post("http://localhost:3032/api/v1/register",
                data
            )
            .then((res) => {
                if (res.data) {
                    toast.success("Đăng ký thành công", {
                        position: "top-right",
                        autoClose: 3000,
                        hideProgressBar: true,
                        closeOnClick: true,
                        pauseOnHover: true,
                        draggable: true,
                        progress: undefined,
                      });
                    navigate("/login");
                }
                
            }).catch((err)=> {
                toast("Đăng ký thất bại", {
                    position: "top-right",
                    autoClose: 3000,
                  });
            })
    }

    return (
        <Container className="border border-2 my-5">
            <Row >
                <Col lg="6" className="mt-5 mb-5 mx-auto">
                    <h4 className="mb-5 text-center">Đăng ký tài khoản</h4>
                    <Row className="mb-3">
                        <Col><Form.Group>
                            <Form.Label>
                                <FontAwesomeIcon icon={faUser} color="#29689b" /> Họ
                            </Form.Label>
                            <Form.Control
                                required name="ho"
                                type="text"
                                placeholder="Nhập vào Họ"
                                onChange={handleChange} 
                            />
                        </Form.Group></Col>
                        <Col><Form.Group>
                            <Form.Label>
                                <FontAwesomeIcon icon={faUser} color="#29689b" /> Tên
                            </Form.Label>
                            <Form.Control
                                required name="ten"
                                type="text"
                                placeholder="Nhập vào Tên"
                                onChange={handleChange} 
                            />
                        </Form.Group></Col>
                    </Row>

                    <Row className="mb-3">
                        <Col>
                            <Form.Group>
                                <Form.Label>
                                    <FontAwesomeIcon icon={faCalendarDays} color="#29689b" /> Ngày sinh
                                </Form.Label>
                                <Form.Control
                                    required name="ngaysinh"
                                    type="date"
                                    placeholder="Enter Your Phone"
                                    onChange={handleChange} 
                                />
                            </Form.Group>
                        </Col>
                        <Col>
                            <Form.Group>
                                <Form.Label className="mb-3">
                                    <FontAwesomeIcon icon={faVenusMars} color="#29689b" /> Giới tính
                                </Form.Label><br />
                                <Form.Check
                                    inline
                                    type="radio" onChange={handleChange}
                                    label="Nam"
                                    name="phai" value={"MALE"}
                                />
                                <Form.Check
                                    inline onChange={handleChange}
                                    type="radio"
                                    label="Nữ"
                                    name="phai" value={"FEMALE"}
                                />
                            </Form.Group>
                        </Col>
                    </Row>
                    <Row className="mb-3">
                        <Form.Group>
                            <Form.Label>
                                <FontAwesomeIcon icon={faPhone} color="#29689b" /> Số điện thoại
                            </Form.Label>
                            <Form.Control
                                required  name="sdt"
                                type="text"
                                placeholder="Nhập số điện thoại"
                                onChange={handleChange} 
                            />
                        </Form.Group>
                    </Row>
                    <Row className="mb-3">
                        <Form.Group className=" ">
                            <Form.Label>
                                <FontAwesomeIcon icon={faAddressCard} color="#29689b" /> Username
                            </Form.Label>
                            <Form.Control
                                required  name="username"
                                type="text"
                                placeholder="Nhập vào Username"
                                className=" rounded-0"
                                onChange={handleChange} 
                            />
                        </Form.Group>
                    </Row>

                    <Row className="mb-3">
                        <Col>
                            <Form.Group className="">
                            <Form.Label>
                                <FontAwesomeIcon icon={faLock} color="#29689b" /> Password
                            </Form.Label>
                            <Form.Control
                                required
                                type="password"  name="password"
                                placeholder="Password"
                                className=" rounded-0"
                                onChange={handleChange} 
                            />
                        </Form.Group>
                        </Col>
                    </Row>
                    <div className='text-center'>
                        <Button
                        variant="primary"
                        className="mb-3 rounded-0 w-50 mt-3"
                        onClick={handleRegister}
                    >
                        Đăng ký
                    </Button>
                    </div>
                    
                </Col>
            </Row>
        </Container>
    );
}

export default Register;