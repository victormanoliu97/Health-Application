import React from 'react';
import './Form-Control.css';
// import { FaPencil } from 'react-icons/fa';

export default class FormControl extends React.Component {
    constructor(...props) {
      super(...props);
  
      this.state={
        editBtn: "#5D737E"
      }
      this.labelRef = React.createRef();
      this.inputRef = React.createRef();
    }
  
    onInputFocus = () => {
      this.labelRef.current.className = "form__label form__label--active";
      this.inputRef.current.style.borderBottom = "2px solid #5D737E";
    }
  
    onInputBlur = () => {
      if (!this.inputRef.current.value) {
        this.inputRef.current.style.borderBottom = "0.7px solid rgba(0, 0, 0, 0.4)";
        this.labelRef.current.className = "form__label";
      } else {
        this.labelRef.current.className = "form__label form__label--active";
      }
  
    }
  
    handleHoverEditBtn = () => {
      this.setState({
        editBtn: "#55505C"
      })
    }
  
    resetEditBtn = () => {
      this.setState({
        editBtn: "#5D737E"
      })
    }
  
    handleEdit = (event) => {
      event.preventDefault();
      this.inputRef.current.disabled = false;
      console.log(this.inputRef);
    }
    render() {
      const { label, name, value, type, onChange, formType } = this.props;
      const { editBtn } = this.state;
      if (!formType) {
        return (
          <div className="form" >
            <div ref={this.labelRef} className="form__label">
              <label>{label}</label>
            </div>
            <div className="form__input">
              <input ref={this.inputRef} name={name} type={type} value={value} onChange={onChange}
                onFocus={this.onInputFocus} onBlur={this.onInputBlur} />
            </div>
          </div>
        )
      } else {
        return (
          <div className="form form--edit">
            <div ref={this.labelRef} className="form--edit__label">
              <label>{label}</label>
            </div>
            <div className="form--edit__input">
              <input ref={this.inputRef} disabled name={name} type={type} value={value}
                onChange={onChange} onFocus={this.onInputFocus} onBlur={this.onInputBlur} />
  
              <div className="form--edit__input__btn">
                <button onClick={this.handleEdit} onMouseOver={this.handleHoverEditBtn} onMouseLeave={this.resetEditBtn}>
                  {/* <FaPencil size={15} color={editBtn}/> */}
                </button>
              </div>
            </div>
  
          </div>
        )
      }
  
    }
  }
  