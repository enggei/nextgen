import { withRouter, Link } from 'react-router-dom';
import ListErrors from './ListErrors';
import React from 'react';
import { inject, observer } from 'mobx-react';

var registerPanel = {
 padding: '5rem 6rem 4rem 6rem',
 minHeight: 'auto'
};

@inject('authStore')
@withRouter
@observer
class RegisterForm extends React.Component {

  componentWillUnmount() {
    this.props.authStore.reset();
  }

  handleEmailChange = e => this.props.authStore.setEmail(e.target.value);

  handlePasswordChange = e => this.props.authStore.setPassword(e.target.value);

  handleOrganizationChange = e => this.props.authStore.setOrganization(e.target.value);

  handleSubmitForm = (e) => {
    e.preventDefault();
    this.props.authStore.register()
      .then(() => this.props.history.replace('/'));
  };


  render() {

    const { values, errors, inProgress } = this.props.authStore;

    return (

        <div className="container">

            <div className="col-md-2 hidden-sm hidden-xs">&nbsp;</div>

            <div className="col-md-8 col-xs-12">
                <h2>Register in Search app</h2>

                 <ListErrors errors={errors} />

               <form onSubmit={this.handleSubmitForm}>
                    <div className="panel panel-default" style={registerPanel} >
                        <div className="panel-body row">
                            <div className="col-lg-6">
                                <div className="form-group">
                                    <label>Email address</label>
                                      <input
                                          className="form-control"
                                          type="email"
                                          placeholder="Email"
                                          value={values.email}
                                          onChange={this.handleEmailChange}
                                          tabIndex="1"
                                        />

                                </div>
                            <div className="form-group">
                                <label>Password</label>
                                 <input
                                      className="form-control"
                                      placeholder="Password"
                                      value={values.password}
                                      onChange={this.handlePasswordChange}
                                      tabIndex="2"
                                      type="password"
                                    />
                            </div>
                        </div>
                    </div>

                    <button className="btn btn-primary btn-sm" id="updateProfile" tabIndex="4" type="submit">
                        &nbsp; REGISTER &nbsp;
                    </button>
                    </div>
                </form>
            </div>

            <div className="col-md-2 hidden-sm hidden-xs">&nbsp;</div>

        </div>
    );
  }
}

export default RegisterForm;
