import React, { useEffect, useState } from "react"
import axios from "axios"
import { faFacebookF, faGoogle } from "@fortawesome/free-brands-svg-icons"
import { Link, useNavigate } from "react-router-dom"
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome"
import { faAddressCard, faLock } from "@fortawesome/free-solid-svg-icons"
import { Container, Row, Col, Form, Button, Alert } from "react-bootstrap"

function Login(props) {
    const [error, setError] = useState(false);
    let navigate = useNavigate();

    const [formValues, setFormValues] = useState({});
    useEffect(()=>{
        props.parentCallback({});
    },[])
    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormValues({...formValues, [name]: value});
    }
    
    const handleSubmit = (e) => {
        console.log((formValues));
        axios
        .post("http://localhost:3032/api/v1/login", 
            formValues
        )
        .then((res) => {
            if(res.data){
                props.parentCallback(res.data);
                navigate("/")
            }
            else{
                setError(true)
            }
        })
    }

    return (
        <Container className="border-2 border my-5">
            <Row>
                <Col lg="6" className=" border-end my-5">
                    <div className="col-7 mx-auto ">
                        <h4 className="mb-4 text-center">Đăng nhập</h4>
                        <Form.Group className="mb-3">
                            <Form.Label>
                                <FontAwesomeIcon icon={faAddressCard} color="#29689b" /> Username
                            </Form.Label>
                            <Form.Control
                                required
                                type="text"
                                name="username"
                                placeholder="Nhập Username"
                                className=" rounded-0"
                                onChange={handleChange}
                            />
                            <Form.Control.Feedback>Looks good!</Form.Control.Feedback>
                        </Form.Group>

                        <Form.Group className="mb-3 " >
                            <Form.Label>
                                <FontAwesomeIcon icon={faLock} color="#29689b" /> Password
                            </Form.Label>
                            <Form.Control
                                required
                                type="password"
                                name="password"
                                placeholder="Nhập Password"
                                className=" rounded-0"
                                onChange={handleChange}
                            />
                            <Form.Control.Feedback>Looks good!</Form.Control.Feedback>
                        </Form.Group>
                        <Form.Group className="mb-3" >
                            <Form.Check type="checkbox" label="Nhớ mật khẩu" />
                            <Link to="/" className="text-decoration-none">
                                Quên mật khẩu
                            </Link>
                        </Form.Group>

                        <div className="text-center">
                            <Button
                                variant="primary"
                                className="mb-3 rounded-0 mx-auto w-75"
                                onClick={handleSubmit}
                            >
                                Đăng nhập
                            </Button>
                        </div>

                        {error && (
                            <Alert variant="danger">Sai tài khoản hoặc mật khẩu. Vui lòng đăng nhập lại</Alert>
                        )}
                        <h4 className="mb-4 text-center">Hoặc</h4>
                        <Button
                            variant="outline-primary"
                            className="mb-3 rounded-0 w-100"
                        >
                            <FontAwesomeIcon icon={faFacebookF} color="blue" /> Facebook
                        </Button>
                        <Button
                            variant="outline-danger"
                            className="mb-3 rounded-0 w-100"
                        >
                            <FontAwesomeIcon icon={faGoogle} color="red" /> Google
                        </Button>
                    </div>

                </Col>
                <Col lg="6" className="mt-5 ps-5">
                    <h4 className="mb-5">Khách hàng mới</h4>
                    <div className="justify-content-between">
                        <p className="mb-5">
                            Bằng cách tạo tài khoản với cửa hàng của chúng tôi, bạn sẽ có thể
                            thực hiện quy trình thanh toán nhanh hơn, lưu trữ nhiều địa chỉ
                            giao hàng, xem và theo dõi đơn đặt hàng trong tài khoản của bạn và
                            hơn thế nữa.
                        </p>
                    </div>

                    <Button
                        variant="primary"
                        type="submit"
                        className="mb-3 rounded-0"
                    >
                        <Link to="/register" className="text-decoration-none text-white">
                            Đăng ký ngay
                        </Link>
                    </Button>
                </Col>
            </Row>
        </Container>
    );
}

export default Login;