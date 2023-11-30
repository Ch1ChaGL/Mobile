const Router = require('express');
const noteController = require('../controller/noteController');
const router = new Router();

router.post('/',noteController.addNote);

router.get('/',noteController.getAllNote);
router.get('/:id',noteController.getNoteById);

router.put('/',noteController.updateNote);

router.delete('/:id', noteController.deleteNote);

module.exports = router;