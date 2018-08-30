import React from 'react';
import './TopMenu.css';
import { Link, Redirect } from 'react-router-dom';

export default class TopMenu extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      redirect_login: false,
      login_pin: ''
    }
  }

  handleLogOutClick = (event) => {
    event.preventDefault();
    localStorage.clear();

    this.setState({
      redirect_login: true
    })
  }

  renderRedirect = () => {
    if (this.state.redirect_login) {
      return <Redirect to="/login" />
    }
  }

  componentDidMount() {
    this.setState({
      user_name: localStorage.getItem("login_pin")
    })
  }
  render() {

    return (
        <h1>Salut</h1>
    );
  }
}
