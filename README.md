Riak Java Playground
====================

This is a bare-bones project template for playing around with Riak using
Basho's official Java client.

How does it work? A `RiakCluster` and `RiakClient` object are set up for
you, assuming that you're running on `localhost`, ports 10017, 10027,
and 10037. Adjust those settings as you see fit.

The `master` branch uses Gradle. Maven support coming soon.

When you first clone the repo, you should fetch all dependencies:

```bash
gradle build
```

At that point, you should be able to run using `gradle run`.
