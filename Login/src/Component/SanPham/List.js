import React, { useState } from 'react';
import axios from 'axios'
import { Button, Form, Container } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';

function List() {

    return (
        <div>
            <h2 className='text-center'>Products List</h2>

            <div className='row'>
                <button className='btn btn-primary' style={{ width: "130px" }}> Add Product </button>
            </div>

            <div className='row'>
                <table className='table table-striped table-bordered'>
                    <thead>
                        <tr>
                            <th>Tên sản phẩm</th>
                            <th>Mô tả</th>
                            <th>Giá tiền</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.products.map(
                                product =>
                                    <tr key={product.id}>
                                        <td> {product.ten_sp} </td>
                                        <td> {product.mo_ta} </td>
                                        <td> {product.gia_tien} </td>
                                        <td>
                                            <button className="btn btn-info">Update</button>
                                        </td>
                                    </tr>
                            )
                        }
                    </tbody>
                </table>
            </div>
        </div>

    )
}
export default List