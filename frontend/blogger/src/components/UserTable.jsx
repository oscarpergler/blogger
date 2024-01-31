import * as React from 'react';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import { useState } from 'react';
import axios from '../api/axios';

export default function UserTable() {

    const [users, setUsers] = useState([]);

    axios.get("/users").then((response) => {
        setUsers(response);
        console.log(response);
    })

    return (
        <TableContainer component={Paper}>
            <Table sx={{ minWidth: 650 }} size="small" aria-label="a dense table">
                <TableHead>
                    <TableRow>
                        <TableCell>Users</TableCell>
                        <TableCell align="right">Username</TableCell>
                        <TableCell align="right">Role</TableCell>
                        <TableCell align="right">Verified</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {users.map((row) => (
                        <TableRow
                            key={row.usersname}
                            sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                        >
                            <TableCell component="th" scope="row">
                                {row.usersname}
                            </TableCell>
                            <TableCell align="right">{row.role}</TableCell>
                            <TableCell align="right">{row.verified}</TableCell>
                        </TableRow>
                    ))}
                </TableBody>
            </Table>
        </TableContainer>
    );
}