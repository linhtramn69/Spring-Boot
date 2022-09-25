import React from 'react';
import { Link } from "react-router-dom"
import { Container, Row, Col } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faFacebookF, faInstagram, faTwitter, faYoutube } from '@fortawesome/free-brands-svg-icons';


function Footer() {

    return (
        <footer>
            <Container>

            <Row className="p-5">
                <Col lg={3} sm={6} className="nav flex-column">
                    <h6>EATCLEAN</h6>
                    <Link to="/">SALAD</Link>
                    <Link to="/">CƠM</Link>
                    <Link to="/">SÚP</Link>
                    <Link to="/">MÓN CHÍNH</Link>
                </Col>
                <Col lg={3} sm={6} className="nav flex-column">
                    <h6>ĐỒ ĂN VẶT KHÁC</h6>
                    <Link to="/">CÁC LOẠI HẠT</Link>
                    <Link to="/">BÁNH MÌ</Link>
                    <Link to="/">BÁNH QUY</Link>
                    <Link to="/">CÁC LOẠI SỮA</Link>
                </Col>
                <Col lg={3} sm={6} className="nav flex-column">
                    <h6>LIÊN HỆ</h6>
                    <Link to="/"><FontAwesomeIcon icon={faFacebookF}/> FACEBOOK</Link>
                    <Link to="/"><FontAwesomeIcon icon={faInstagram}/> INSTAGRAM</Link>
                    <Link to="/"><FontAwesomeIcon icon={faTwitter}/> TWITTER</Link>
                    <Link to="/"><FontAwesomeIcon icon={faYoutube}/> YOUTUBE</Link>
                </Col>
                <Col lg={3} sm={6} className="nav flex-column">
                    <h6>THÔNG TIN PHÁP LÝ</h6>
                    <Link to="/">ĐIỀU KHOẢN SỬ DỤNG</Link>
                    <Link to="/">THÔNG TIN BẢO MẬT</Link>
                    <Link to="/">COOKIE</Link>
                </Col>
            </Row>
            </Container>
    </footer>
    )
}
export default Footer
