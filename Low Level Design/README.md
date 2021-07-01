Important part of actually writing a proper LLD code is to actually understand the requirement
So, this how it should go ideally
    -> Get a clear list of requirements
    -> Try to create a proper Use-case diagram with proper class designs and actors of various types (mostly it is users and admins, but be prepared for anything)
    -> Once we have that, create a proper mapping of one-to-one or one-to-many type in that relationship diagram
    -> With this, we have a proper idea of how the things have to go
        -> Now just choose a design pattern like factory or adaptor, whichever suits the case best
        -> And start coding with that