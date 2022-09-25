import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
    faPhone,
    faEnvelope,
    faUser,
    faLock,
    faVenusMars,
    faAddressCard,
} from "@fortawesome/free-solid-svg-icons";
import {
    Container,
    Row,
    Col,
    Form,
    Button,
    Breadcrumb,
    Alert,
} from "react-bootstrap";
import { faCalendarDays } from "@fortawesome/free-regular-svg-icons";

function Register() {
    const [message, setMessage] = useState("");
    const [name, setName] = useState("");
    const [phone, setPhone] = useState("");
    const [emailReg, setEmailReg] = useState("");
    const [passwordReg, setPasswordReg] = useState("");
    let navigate = useNavigate();

    const handleSubmit = (event) => {
        navigate("/login");
    };

    return (
        <Container className="border border-2 my-5">
            <Row >
                <Col lg="6" className="mt-5 mb-5 mx-auto">
                    <h4 className="mb-5 text-center">Đăng ký tài khoản</h4>
                    <Row className="mb-3">
                        <Col><Form.Group controlId="formGridEmail">
                            <Form.Label>
                                <FontAwesomeIcon icon={faUser} color="#29689b" /> Họ
                            </Form.Label>
                            <Form.Control
                                required
                                type="text"
                                value={name}
                                placeholder="Nhập vào Họ"
                                onChange={(e) => setName(e.target.value)}
                            />
                        </Form.Group></Col>
                        <Col><Form.Group controlId="formGridEmail">
                            <Form.Label>
                                <FontAwesomeIcon icon={faUser} color="#29689b" /> Tên
                            </Form.Label>
                            <Form.Control
                                required
                                type="text"
                                value={name}
                                placeholder="Nhập vào Tên"
                                onChange={(e) => setName(e.target.value)}
                            />
                        </Form.Group></Col>
                    </Row>

                    <Row className="mb-3">
                        <Col>
                            <Form.Group controlId="formGridPassword">
                                <Form.Label>
                                    <FontAwesomeIcon icon={faCalendarDays} color="#29689b" /> Ngày sinh
                                </Form.Label>
                                <Form.Control
                                    required
                                    type="date"
                                    placeholder="Enter Your Phone"
                                    onChange={(e) => setPhone(e.target.value)}
                                />
                            </Form.Group>
                        </Col>
                        <Col>
                            <Form.Group controlId="formGridPassword">
                                <Form.Label className="mb-3">
                                    <FontAwesomeIcon icon={faVenusMars} color="#29689b" /> Giới tính
                                </Form.Label><br />
                                <Form.Check
                                    inline
                                    type="radio"
                                    label="Nam"
                                    name="gioitinh"
                                />
                                <Form.Check
                                    inline

                                    type="radio"
                                    label="Nữ"
                                    name="gioitinh"
                                />
                                <Form.Check
                                    inline

                                    type="radio"
                                    label="Khác"
                                    name="gioitinh"
                                />
                            </Form.Group>
                        </Col>
                    </Row>
                    <Row className="mb-3">
                        <Form.Group controlId="formGridPassword">
                            <Form.Label>
                                <FontAwesomeIcon icon={faPhone} color="#29689b" /> Số điện thoại
                            </Form.Label>
                            <Form.Control
                                required
                                type="text"
                                placeholder="Nhập số điện thoại"
                                onChange={(e) => setPhone(e.target.value)}
                            />
                        </Form.Group>
                    </Row>
                    <Row className="mb-3">
                        <Form.Group className=" " controlId="formBasicEmail">
                            <Form.Label>
                                <FontAwesomeIcon icon={faAddressCard} color="#29689b" /> Username
                            </Form.Label>
                            <Form.Control
                                required
                                type="text"
                                placeholder="Nhập vào Username"
                                className=" rounded-0"
                                onChange={(e) => setEmailReg(e.target.value)}
                            />
                        </Form.Group>
                    </Row>

                    <Row className="mb-3">
                        <Col>
                            <Form.Group className="" controlId="formBasicPassword">
                            <Form.Label>
                                <FontAwesomeIcon icon={faLock} color="#29689b" /> Password
                            </Form.Label>
                            <Form.Control
                                required
                                type="password"
                                placeholder="Password"
                                className=" rounded-0"
                                onChange={(e) => setPasswordReg(e.target.value)}
                            />
                        </Form.Group>
                        </Col>
                        <Col>
                            <Form.Group className="" controlId="formBasicPassword">
                            <Form.Label>
                                <FontAwesomeIcon icon={faLock} color="#29689b" /> Nhập lại Password
                            </Form.Label>
                            <Form.Control
                                required
                                type="password"
                                placeholder="Nhập lại Password"
                                className=" rounded-0"
                                onChange={(e) => setPasswordReg(e.target.value)}
                            />
                        </Form.Group>
                        </Col>
                    </Row>
                    {message && <Alert variant="danger">{message}</Alert>}
                    <div className='text-center'>
                        <Button
                        variant="primary"
                        className="mb-3 rounded-0 w-50 mt-3"
                        onClick={handleSubmit}
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