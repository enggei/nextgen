virtual environment:

source ~/tensorflow/bin/activate

docker run -it gcr.io/tensorflow/tensorflow bash

python

import tensorflow as tf
hello = tf.constant('Hello, TensorFlow!')
sess = tf.Session()
print(sess.run(hello))


https://www.tensorflow.org/install/install_sources