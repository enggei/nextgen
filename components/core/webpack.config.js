
const path = require('path');
const HtmlWebPackPlugin = require("html-webpack-plugin");

module.exports = {
  entry: { main: './src/main/js/index.js' },
  output: {
    path: path.resolve(__dirname, 'target'),
    filename: 'main.js'
  },
  module: {
    rules: [
      {
        test: /\.js$/,
        exclude: /node_modules/,
        use: {
          loader: "babel-loader"
        }
      },
      {
        test: /\.svg$/,
        use: [
          {
            loader: "babel-loader"
          },
          {
            loader: "react-svg-loader",
            options: {
              jsx: true // true outputs JSX tags
            }
          }
        ]
      },
      {
        test: /\.css$/,
        use: [ 'style-loader', 'css-loader' ]
      },
      {
          test: /\.scss$/,
          use: [
              "style-loader", // creates style nodes from JS strings
              "css-loader", // translates CSS into CommonJS
              "sass-loader" // compiles Sass to CSS, using Node Sass by default
          ]
      },
      {
        test: /\.html$/,
        use: [
           {
              loader: "html-loader"
           }
        ]
      },
      {
          test: /\.(woff|woff2|eot|ttf|otf)$/,
          loader: "file-loader"
      },
      {
        test: /\.(gif|png|jpe?g)$/i,
        use: [
          'file-loader',
          {
            loader: 'image-webpack-loader',
            options: {
              bypassOnDebug: true, // webpack@1.x
              disable: true, // webpack@2.x and newer
            },
          },
        ],
      }
    ]
  },
  plugins: [
    new HtmlWebPackPlugin({
      template: "./src/main/js/index.html",
      filename: "./index.html"
    })
  ]
};