import React from 'react';
import { Switch, Route } from 'react-router-dom';
import Login from './pages/login-page/Login';

const Main = () => {
    <Switch>
       <Route exact path="/login" component={Login} />
    </Switch>
}
export default Main;