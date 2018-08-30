import React, { Component } from 'react';
import Main from './routes';
import TopMenu from './common/top-menu/TopMenu';
import Login from './pages/login-page/Login';

export default class App extends Component {
  render() {
    

    return (
      <div className="App">
        {localStorage.getItem("isAuth") && <TopMenu />}
        <div className="container">
          <Login/>
        </div>
      </div>
    );
  }
}
