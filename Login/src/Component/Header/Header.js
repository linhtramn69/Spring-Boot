import React from 'react';
import { Link } from "react-router-dom"
import { Nav, Navbar, Container, NavDropdown, FormControl, Button, InputGroup } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faCircleUser } from "@fortawesome/free-regular-svg-icons";
import {
    faRightFromBracket,
    faBagShopping,
    faSearch,

} from "@fortawesome/free-solid-svg-icons";

function Header(UserLogin) {
    console.log(UserLogin);
    return (
        <header className="position-sticky" style={{ top: "0", zIndex: "1000" }}>
            <div className="header-title">
                <Link to="/" className="text-decoration-none">
                    <h5 className="text-center p-2 text-white">EATCLEAN</h5>
                </Link>
            </div>
            <Navbar style={{ backgroup: "white" }} expand="lg" fill className=''>
                <Container className="">
                    <Navbar.Toggle aria-controls="basic-navbar-nav" />
                    <Navbar.Collapse id="basic-navbar-nav" className="justify-content-center">
                        <Nav className="align-items-center nav-header">
                            <Link to="/">TẤT CẢ</Link>
                            <Link to="/">SALAD</Link>
                            <Link to="/">CƠM</Link>
                            <Link to="/">SÚP</Link>
                            <Link to="/">MÓN CHÍNH</Link>
                            <NavDropdown title="ĐỒ ĂN VẶT KHÁC" >
                                <Link to="/" className='dropdown-item'>CÁC LOẠI HẠT</Link>
                                <Link to="/" className='dropdown-item'>BÁNH MÌ</Link>
                                <Link to="/" className='dropdown-item'>BÁNH QUY</Link>
                                <Link to="/" className='dropdown-item'>CÁC LOẠI SỮA</Link>
                            </NavDropdown>
                        </Nav>
                        <div className=" mx-4">
                            <InputGroup >
                                <FormControl style={{ height: "33px" }}
                                    placeholder="Bạn cần tìm gì?"
                                    className="rounded-end rounded-pill border-secondary"
                                />
                                <Button className="rounded-start rounded-pill border-start-0 border-secondary" style={{ background: "white", height: "33px" }}>
                                    <Link to=""><FontAwesomeIcon icon={faSearch} color="black" style={{ fontSize: "0.9em", margin: "auto" }} /> </Link>
                                </Button>
                            </InputGroup>
                        </div>
                        <div className=" mt-1 ms-4">
                            <Link to="" className="me-4"><FontAwesomeIcon icon={faBagShopping} style={{ fontSize: "1.5em" }
                            } color="black" /> </Link>
                            <Link to="/login"><FontAwesomeIcon icon={faCircleUser} style={{ fontSize: "1.5em" }} color="black" /> </Link>
                            {UserLogin.UserLogin.ten && UserLogin.UserLogin.ten}
                            {UserLogin.UserLogin.ten &&(< Link to="/login" className='text-decoration-none text-dark ms-4'
                            >
                                <FontAwesomeIcon icon={faRightFromBracket} color="black" /> Đăng xuất
                            </Link>)}
                        </div>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
        </header >
    )
}
export default Header