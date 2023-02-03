import http from 'k6/http';
import {check} from 'k6';

export default function () {
    const res = http.get('http://localhost:9000/rate/limit');
    check(res, {
        'status is 200': (r) => r.status === 200,
        'protocol is HTTP/1.1': (r) => r.proto === 'HTTP/1.1',
    });
}