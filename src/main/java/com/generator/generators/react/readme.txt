
# client - using npm
npm init
npm i webpack -S

# babel, ES6, JSX
npm install babel-core babel-loader babel-preset-es2015 babel-plugin-transform-object-rest-spread babel-preset-react  -S --save-dev

# allow decorators
npm install babel-plugin-transform-decorators-legacy --save-dev
npm install babel-preset-stage-0 --save-dev

# react + react-router
npm install react react-dom react-router react-router-dom prop-types -S

# mobx for data-layer
npm install mobx mobx-react -S

# utilities
npm install uuid -S

# axios for api-calls
npm install axios -S

# socket.io for websockets
npm install socket.io socket.io-react -S

# look and feel (material ui)
npm install material-ui react-tap-event-plugin -S



# webpack.config.js
var webpack = require('webpack');
var path = require('path');

var BUILD_DIR = path.resolve(__dirname, 'src/main/web/');
var APP_DIR = path.resolve(__dirname, 'src/main/web/');

var config = {
  entry: APP_DIR + '/index.js',
  output: {
    path: BUILD_DIR,
    filename: 'app.js'
  },
  module : {
      loaders : [
        {
          test : /\.jsx?/,
          include : APP_DIR,
          loader : 'babel-loader',
          query: {
            presets: ['es2015', 'react'],
            plugins: ['transform-object-rest-spread', 'transform-decorators-legacy', 'transform-class-properties']
          }
        }
      ]
    }
};

new webpack.DefinePlugin({
  'process.env': {
    NODE_ENV: JSON.stringify('production')
  }
}),
new webpack.optimize.UglifyJsPlugin()

module.exports = config;



#update package.json to support dev and live builds
{
  ...

  "scripts": {
    "dev": "webpack -d --watch",
    "live" : "webpack -p"
  },

  ...
}

# this allows you to:
# run npm (developer, with --watch for filechanges)
npm run dev

# run npm (live, react-optmization)
npm run live