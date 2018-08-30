import React from 'react';
import './Button.css';

export default class Button extends React.Component {

    render() {
    const { onClickFunction, name , type } = this.props;
  
    if(type === "" || type == null) {
      return (
        <div className="button">
          <button className="default" onClick={onClickFunction}>{this.props.children}{name}</button>
        </div>
      )
    } else {
      return (
        <div className="button">
          <button className={type} onClick={onClickFunction}>{this.props.children}{name}</button>
        </div>
      )
    }
      
   }
}