import React from 'react';
import { Link, Redirect } from 'react-router-dom';
import './Login.css';
import { auth } from '../../services/authService';
import FormControl from '../../common/form-control/Form-Control';
import Button from '../../common/button/Button';
import Title from '../../common/title/Title';

export default class Login extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      login_pin: '',
      isLogged: false,
      redirect: false,
      loginErr: false
    }

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  setRedirect = () => {
    this.setState({
      redirect: true
    })
  }
  setLoginErr = (message) => {
    this.setState({
      loginErr: message
    })
  }

  handleChange(event) {
    const target = event.target;
    const value = target.value;
    const name = target.name;

    this.setState({
      [name]: value
    });
  }

  renderRedirect = () => {
    if (this.state.redirect) {
      return <Redirect to='/' />
    }
  }
  handleSubmit(event) {
    event.preventDefault();

    const {login_pin} = this.state;

    if (login_pin.length === 0) {
      console.log("Please fill all fields");
    } else {
      auth(this.state).then(response => {
        console.log(response);
        if (response.status !== 200) {
          this.setLoginErr(response.message);
        } else {
          localStorage.setItem("isAuth", true);
          localStorage.setItem("loginPin", this.state.login_pin);
          this.setRedirect();
        }
      })
    } 
  }

  componentWillMount() {
    if (localStorage.getItem("isAuth")) {
      this.setState({
        isLogged: true
      })
    }
  }
  render() {
    const { login_pin } = this.state;

    return (
      <div className="login">
        {this.state.isLogged && <Redirect to="/" />}
        <div className="login__container">
          <Title text="Log in" />
          {this.state.loginErr}

          <div className="login__container__form">

            <form onSubmit={this.handleSubmit}>
              <div className="login__container__form__fields">
                <FormControl label="Login PIN" name="login_pin" value={login_pin} 
                  type="text" //placeholder="Login PIN"
                  onChange={this.handleChange} />
              
                <Button name="Log in" />
                {/* <button className="login__container__form__fields__submit" type="submit"> Log in </button> */}

              </div>

            </form>

          </div>

        </div>
        {this.state.redirect && this.renderRedirect()}
      </div>
    );
  }
}
