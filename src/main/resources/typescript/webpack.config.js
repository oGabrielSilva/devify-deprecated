const path = require("path");

module.exports = {
  entry: path.resolve(__dirname, "index.ts"),
  devtool: "inline-source-map",
  mode: "production",
  module: {
    rules: [
      {
        test: /\.tsx?$/,
        use: "ts-loader",
        exclude: /node_modules/,
      },
    ],
  },
  resolve: {
    extensions: [".tsx", ".ts", ".js"],
  },
  output: {
    filename: "app.dist.min.js",
    path: path.resolve(__dirname, "..", "static", "javascript"),
  },
};
