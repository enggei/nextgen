import { withRouter, Link } from 'react-router-dom';
import ListErrors from '../ListErrors';
import React from 'react';
import { inject, observer } from 'mobx-react';

var loginPanel = {
 padding: '5rem 6rem 4rem 6rem',
 minHeight: 'auto'
};


@inject('authStore')
@withRouter
@observer
class LogoutForm extends React.Component {

  componentWillUnmount() {
    this.props.authStore.reset();
  }

  handleSubmitForm = (e) => {
    e.preventDefault();
    this.props.authStore.logout()
      .then(() => this.props.history.replace('/'));
  };

  render() {

    const { values, errors, inProgress } = this.props.authStore;


    return (

        <div className="container">

            <div className="col-md-2 hidden-sm hidden-xs">&nbsp;</div>

            <div className="col-md-8 col-xs-12">
                <h2>Logout</h2>

                <ListErrors errors={errors} />

                <form onSubmit={this.handleSubmitForm}>
                    <button className="btn btn-primary btn-sm" id="updateProfile" tabIndex="3" type="submit">
                        &nbsp; LOG OUT &nbsp;
                    </button>
                </form>
            </div>

            <div className="col-md-2 hidden-sm hidden-xs">&nbsp;</div>

        </div>
    );
  }
}

export default LogoutForm;
