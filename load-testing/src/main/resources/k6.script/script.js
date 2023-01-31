import http from 'k6/http';
import {check} from 'k6';

export const options = {
    discardResponseBodies: true,
    scenarios: {
        contacts: {
            executor: 'ramping-vus',
            startVUs: 0,
            stages: [
                { duration: '1s', target: 10 },
                { duration: '1s', target: 0 },
            ],
            gracefulRampDown: '0s',
        },
    },
};


export default function () {
    const res = http.get('http://localhost:8080/');
    check(res, {
        'status is 200': (r) => r.status === 200,
        'protocol is HTTP/1.1': (r) => r.proto === 'HTTP/1.1',
    });
}