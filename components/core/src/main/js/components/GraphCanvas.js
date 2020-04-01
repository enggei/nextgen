import { withRouter, Link } from 'react-router-dom';
import ListErrors from './ListErrors';
import React from 'react';
import { Grid, Row, Col } from 'react-bootstrap';
import { inject, observer } from 'mobx-react';
import { Graph } from 'react-d3-graph';

import LoadingSpinner from './LoadingSpinner';

@inject('graphStore')
@withRouter
@observer
class GraphCanvas extends React.Component {

    componentWillMount() {
        this.props.graphStore.reset();
    }

  render() {

        if (this.props.graphStore.isLoading) {
            return (
                <LoadingSpinner />
            );
        }


        const { nodes, links } = this.props.graphStore;
        console.info("nodes = " + nodes);
        const data = { nodes, links };

        // the graph configuration, you only need to pass down properties
        // that you want to override, otherwise default ones will be used
        const myConfig = {
            nodeHighlightBehavior: true,
            node: {
                color: 'lightgreen',
                size: 120,
                highlightStrokeColor: 'blue'
            },
            link: {
                highlightColor: 'lightblue'
            }
        };

        // graph event callbacks
        const onClickNode = function(nodeId) {
            console.info(`Clicked node ${nodeId}`);
        };

        const onMouseOverNode = function(nodeId) {
            console.info(`Mouse over node ${nodeId}`);
        };

        const onMouseOutNode = function(nodeId) {
            console.info(`Mouse out node ${nodeId}`);
        };

        const onClickLink = function(source, target) {
            console.info(`Clicked link between ${source} and ${target}`);
        };

        const onMouseOverLink = function(source, target) {
            console.info(`Mouse over in link between ${source} and ${target}`);
        };

        const onMouseOutLink = function(source, target) {
            console.info(`Mouse out link between ${source} and ${target}`);
        };


        return (

            <div className="graph_panel">
                <div className="container__graph">
                   <Graph
                         id="graph-id" // id is mandatory, if no id is defined rd3g will throw an error
                         data={data}
                         config={myConfig}
                         onClickNode={onClickNode}
                         onClickLink={onClickLink}
                         onMouseOverNode={onMouseOverNode}
                         onMouseOutNode={onMouseOutNode}
                         onMouseOverLink={onMouseOverLink}
                         onMouseOutLink={onMouseOutLink}
                     />
                </div>
                <div className="container__form">
                  <h4>
                      <a href="https://github.com/danielcaldas/react-d3-graph" target="_blank">
                          react-d3-graph
                      </a>
                  </h4>
                </div>
            </div>
        );
    }
}

export default GraphCanvas;