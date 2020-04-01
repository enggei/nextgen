import { withRouter, Link } from 'react-router-dom';
import ListErrors from '../ListErrors';
import React from 'react';
import { inject, observer } from 'mobx-react';

var loginPanel = {
 padding: '5rem 6rem 4rem 6rem',
 minHeight: 'auto'
};

var forgotPassword = {
    color: '#fff'
}

@inject('authStore')
@withRouter
@observer
class LoginForm extends React.Component {

  componentWillUnmount() {
    this.props.authStore.reset();
  }

  handleUsernameChange = e => this.props.authStore.setUsername(e.target.value);

  handlePasswordChange = e => this.props.authStore.setPassword(e.target.value);

  handleSubmitForm = (e) => {
    e.preventDefault();
    this.props.authStore.login()
      .then(() => this.props.history.replace('/'));
  };

  render() {

    const { values, errors, inProgress } = this.props.authStore;


    return (

        <div className="container">

            <div className="col-md-2 hidden-sm hidden-xs">&nbsp;</div>

            <div className="col-md-8 col-xs-12">
                <h2>Log in to Search app</h2>

                <ListErrors errors={errors} />

                <form onSubmit={this.handleSubmitForm}>
                    <div className="panel panel-default" style={loginPanel} >
                        <div className="panel-body row">
                            <div className="col-lg-6">
                                <div className="form-group">
                                    <label>Username</label>

                                    <input
                                      className="form-control"
                                      type="text"
                                      placeholder="Username"
                                      value={values.username}
                                      onChange={this.handleUsernameChange}
                                      tabIndex="1"
                                    />
                                </div>
                            <div className="form-group">
                                <label>Password</label>

                                <input
                                  className="form-control"
                                  type="password"
                                  placeholder="Password"
                                  value={values.password}
                                  onChange={this.handlePasswordChange}
                                  tabIndex="1"
                                />
                            </div>
                        </div>
                    </div>

                    <button className="btn btn-primary btn-sm" id="updateProfile" tabIndex="3" type="submit">
                        &nbsp; LOG IN &nbsp;
                    </button>
                        <a className="" href="/password-recovery" style={forgotPassword} tabIndex="4">Forgot password?</a>
                    </div>
                </form>
            </div>

            <div className="col-md-2 hidden-sm hidden-xs">&nbsp;</div>

        </div>
    );
  }
}

export default LoginForm;
