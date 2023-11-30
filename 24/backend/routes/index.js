const Router = require('express');
const notesRouter = require('./NotesRouter');
const router = new Router();

router.use('/note',notesRouter);

module.exports = router;