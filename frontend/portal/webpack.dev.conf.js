var sprite = require('sprite-webpack-plugin');

module.exports = {
  plugins: [
    new sprite({
      'source' : __dirname + '/assets/images/icons',
      'imgPath': __dirname + '/assets/images/',
      'cssPath': __dirname + '/assets/images/css',
      'prefix': 'icon',
      'connector': "-"
    })
]
}
